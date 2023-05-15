import { NextFunction, Request, Response } from "express";
import admin from "firebase-admin";
const serviceAccount = require("./config/firebase-key.json");

const bucketAddress = "ed-burguer-ae2c8.appspot.com";

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  storageBucket: bucketAddress,
});

const bucket = admin.storage().bucket();

export const uploadImage = (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  if (!req.file) return next();

  const img = req.file;
  const nomeArquivo = Date.now() + "-" + img.originalname;

  const file = bucket.file(nomeArquivo);

  const stream = file.createWriteStream({
    metadata: {
      contentType: img.mimetype,
    },
  });

  stream.on("error", (err) => console.error(err));

  stream.on("finish", async () => {
    await file.makePublic();

    req.file!.path = `https://storage.googleapis.com/${bucketAddress}/${nomeArquivo}`;

    next();
  });

  stream.end(img.buffer);
};

import { NextFunction, Request, Response } from "express";
import admin from "firebase-admin";
import { initializeApp } from "firebase/app";
import { getStorage, ref, deleteObject } from "firebase/storage";
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

const app = initializeApp({
  storageBucket: bucketAddress,
});
const storage = getStorage(app);

export const deleteImage = (req: Request, res: Response) => {
  let url = req.params.url;

  const imageRef = ref(storage, `${url}`);

  deleteObject(imageRef)
    .then(() => res.status(200).send("sucess"))
    .catch((err) => res.status(401).json({ error: err }));
};

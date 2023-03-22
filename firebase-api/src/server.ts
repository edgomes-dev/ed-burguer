import cors from "cors";
import express from "express";
import Multer from "multer";
import { uploadImage } from "./firebase";

const app = express();
app.use(express.json())
app.use(cors());

const multer = Multer({
  storage: Multer.memoryStorage(),
  limits: {
    fileSize: 1024 * 1024
  }
});

app.post('/firebase', multer.single("img"), uploadImage,async (request, response) => {
  response.status(200).json({ data: request.file?.path });
})

app.listen('3333', () => console.log('Servidor Iniciado'));

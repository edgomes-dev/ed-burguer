import { BrowserRouter, Routes, Route } from "react-router-dom"
import { Home } from "./pages";

export const Router = () => (
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home />} />
    </Routes>
  </BrowserRouter>
);
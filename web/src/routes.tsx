import { BrowserRouter, Routes, Route } from "react-router-dom"
import { HomePage, CategoryPage, SingInPage, SingUpPage } from "./pages";

export const Router = () => (
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/category/:type" element={<CategoryPage />} />
      <Route path="/sing-in" element={<SingInPage />} />
      <Route path="/sing-up" element={<SingUpPage />} />
    </Routes>
  </BrowserRouter>
);
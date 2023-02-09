import * as S from "./styles"
import { BsCart2 } from "react-icons/bs"

export function MenuComponent() {
  return (
    <S.Container>
      <S.Icone><a href="/"><span>Ed</span> Burguer</a> </S.Icone>
      <ul>
        <li><a href="#">Bebidas</a></li>
        <li><a href="#">Lanches</a></li>
        <li><a href="#">Pizzas</a></li>
        <li><a href="#">Cardápio completo</a></li>
      </ul>
      <div>
        <BsCart2 size={28} />
        <a href="#">Meus pedidos</a>
      </div>
    </S.Container>
  )
}
import * as S from "./styles"

export function MenuComponent() {
  return (
    <S.Container>
      <S.Icone><span>Ed</span> Burguer</S.Icone>
      <ul>
        <li>Bebidas</li>
        <li>Lanches</li>
        <li>Pizzas</li>
        <li>Cardápio completo</li>
      </ul>
      <div>
        <p>Carrinho</p>
        <button>Meus pedidos</button>
      </div>
    </S.Container>
  )
}
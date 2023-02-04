import * as S from "./styles"
import { productListMock } from "../../mocks/productsList"

export function CardItemComponent() {
  return (
    <S.Container>
      {productListMock.map((product) => (
        <S.Card>
          <S.Image src={product.image} />
          <S.Details>
            <p>R${product.price}</p>
            <S.Link href="#">Pedir</S.Link>
          </S.Details>
        </S.Card>
      ))}
    </S.Container>
  )
}
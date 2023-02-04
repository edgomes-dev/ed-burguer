import { CardItemComponent } from ".."
import * as S from "./styles"

export function CardListComponent() {
  return (
    <S.Container>
      <h3>Mais vendidos</h3>
      <CardItemComponent />
      <a id="link" href="#">Veja o cardápio completo</a>
    </S.Container>
  )
}
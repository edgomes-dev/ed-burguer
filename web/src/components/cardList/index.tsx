import { CardItemComponent } from ".."
import * as S from "./styles"

type CardListComponentPropsType = {
  title: string;
}

export function CardListComponent({title}: CardListComponentPropsType) {
  return (
    <S.Container>
      <h3>{title}</h3>
      <CardItemComponent />
      <a id="link" href="#">Veja o cardápio completo</a>
    </S.Container>
  )
}
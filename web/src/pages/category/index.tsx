import { useParams } from "react-router-dom"
import { CardListComponent, FooterComponent, MenuComponent } from "../../components";
import * as S from "./styles"

export function CategoryPage() {
  const { type } = useParams();

  return (
    <S.Container>
      <MenuComponent />
      <CardListComponent title={type!} />
      <FooterComponent />
    </S.Container>
  )
}
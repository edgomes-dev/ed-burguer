import * as S from "./styles"
import { CardListComponent, FooterComponent, MenuComponent } from "../../components";
import backgroundImage from "/public/images/burguer-home-background.jpg"
import { CardItemComponent } from "../../components/cardItem";

export function HomePage() {
  return (
    <S.Container>
      <MenuComponent />
      <S.Image src={backgroundImage} />
      <CardListComponent title="Mais vendidos" />
      <FooterComponent />
    </S.Container>
  )
}
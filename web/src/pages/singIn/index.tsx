import { FooterComponent, MenuComponent } from "../../components"
import * as S from "./styles"

export function SingInPage() {
  return (
    <S.Container>
      <MenuComponent />
      <h3>Login</h3>
      <S.Form>
        <div>
          <label htmlFor="email">E-mail</label>
          <input type="email" id="email" />
        </div>
        <div>
          <label htmlFor="password">Senha</label>
          <input type="password" id="password" />
        </div>
        <input type="submit" value="Entrar" />
      </S.Form>
      <FooterComponent />
    </S.Container>
  )
}
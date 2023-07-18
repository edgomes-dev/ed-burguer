import Link from 'next/link';
import * as S from './styles';

export function LoginTemplate() {
  return (
    <S.Wrapper>
      <S.Form>
        <Link href="/">Voltar ao menu</Link>
        <h2>Login</h2>
        <form>
          <label htmlFor="email">
            <span>E-mail</span>
            <input type="email" name="email" id="email" />
          </label>
          <label htmlFor="password">
            <span>Senha</span>
            <input type="password" name="password" id="password" />
          </label>
          <input type="submit" value="Entrar" />
        </form>
        <p>
          Não tem uma conta ? <a href="/login">Cadastre-se agora!</a>
        </p>
      </S.Form>
    </S.Wrapper>
  );
}

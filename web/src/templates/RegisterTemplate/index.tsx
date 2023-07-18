import * as S from './styles';

export function RegisterTemplate() {
  return (
    <S.Wrapper>
      <S.Form>
        <h2>Register</h2>
        <form>
          <label htmlFor="name">
            <span>Nome</span>
            <input type="text" id="name" placeholder="Seu nome completo" />
          </label>
          <label htmlFor="email">
            <span>E-mail</span>
            <input type="email" id="email" placeholder="voce@exemplo.com.br" />
          </label>
          <label htmlFor="password">
            <span>Senha</span>
            <input type="password" id="password" placeholder="Sua senha" />
          </label>
          <input type="submit" value="Registrar" />
        </form>
        <p>
          já tem uma conta ? <a href="/login">Entre agora!</a>
        </p>
      </S.Form>
    </S.Wrapper>
  );
}

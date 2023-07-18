import * as S from './styles';

export function OfficeHours() {
  return (
    <S.Wrapper>
      <S.Title>
        <h3>Horário</h3>
        <S.Close>X</S.Close>
      </S.Title>
      <S.Text>
        No momento nós estamos fechados, você pode conferir nosso cardápio e
        pedir quando abrirmos. Confira nosso horário de funcionamento abaixo.
      </S.Text>
      <div>
        <S.DateItem>
          <p>Domingo:</p>
          <span>18:00 - 00:00</span>
        </S.DateItem>
        <S.DateItem>
          <p>Segunda-feira:</p>
          <span>18:00 - 00:00</span>
        </S.DateItem>
        <S.DateItem>
          <p>Terça-feira:</p>
          <span>18:00 - 00:00</span>
        </S.DateItem>
        <S.DateItem>
          <p>Quarta-feira:</p>
          <span>18:00 - 00:00</span>
        </S.DateItem>
        <S.DateItem>
          <p>Quinta-feira:</p>
          <span>18:00 - 00:00</span>
        </S.DateItem>
        <S.DateItem>
          <p>Sexta-feira:</p>
          <span>18:00 - 00:00</span>
        </S.DateItem>
        <S.DateItem>
          <p>Sábado:</p>
          <span>18:00 - 00:00</span>
        </S.DateItem>
      </div>
    </S.Wrapper>
  );
}

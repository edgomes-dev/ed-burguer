import styled from 'styled-components';
import { css } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    width: 80vw;
    margin: 0 auto;

    .pending {
      display: flex;
    }

    button {
      height: 5rem;
      background-color: ${theme.colors.gray.dark};
      color: ${theme.colors.white};
    }
  `}
`;

export const Cards = styled.div``;

export const TopCards = styled.div`
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 2.5rem;
`;

export const Card = styled.div`
  ${({ theme }) => css`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: ${theme.colors.white};
    border-radius: 5px;
    box-shadow: 1px 1px 1px 1px rgba(0, 0, 0, 0.4);
    padding: 30px 0;

    div {
      display: flex;
      align-items: center;
      gap: 5px;
    }

    span {
      font-size: 28pt;
    }

    p {
      font-size: ${theme.font.sizes.large};
    }
  `}
`;

export const BottomCards = styled.div`
  display: grid;
  width: 80%;
  margin: 0 auto;
  margin-top: 1rem;
  grid-template-columns: repeat(3, 1fr);
  gap: 2.5rem;
`;

export const CardMini = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: ${theme.colors.white};
    border-radius: 5px;
    box-shadow: 1px 1px 1px 1px rgba(0, 0, 0, 0.4);
    padding: 15px 10px;

    div {
      display: flex;
      align-items: center;
      gap: 5px;
    }
  `}
`;

export const ManagerArea = styled.div`
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2.5rem;
  margin: 2rem 0;

  h3 {
    padding: 1rem 0px;
    border-bottom: 0.0625rem solid rgba(0, 0, 0, 0.3);
    text-align: center;
    width: 100%;
  }

  .column {
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.05);
    border: 0.0625rem solid rgba(231, 234, 243, 0.7);
    max-height: 450px;
  }
`;

export const LeftArea = styled.div`
  overflow: auto;
`;

export const StaffTable = styled.div`
  display: flex;
  flex-direction: column;
  padding: 21px;
  gap: 1.25rem;
`;

export const StaffItemTable = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  .information {
    display: flex;
    align-items: center;
    gap: 1rem;

    div {
      p {
        font-size: 1.25em;
        font-weight: bolder;
      }

      span {
        font-size: 1.1em;
      }
    }
  }

  span {
    font-size: 1.2em;
  }
`;

export const OrderPending = styled.div`
  ${({ theme }) => css`
    background-color: ${theme.colors.orange.main};
    display: flex;
    justify-content: center;
    gap: 1rem;
    width: 30rem;
    padding: 1.5rem;

    div {
      text-align: center;

      span {
        font-size: 1.8em;
      }
    }
  `}
`;

export const MidArea = styled.div`
  h3 {
    text-align: center;
  }
`;

export const NoticeArea = styled.div`
  display: flex;
  flex-direction: column;
  height: 90%;
  justify-content: center;
  padding: 21px;
`;

export const NoticeElement = styled.div`
  padding: 14px;
  border: 0.0625rem solid rgba(0, 0, 0, 0.4);
`;

export const RightArea = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1.25rem;

  div {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
  }

  .graph {
    width: 150px;
    height: 150px;
  }
`;

export const Seller = styled.div`
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2.5rem;
`;

export const Collum = styled.div`
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.05);
  border: 0.0625rem solid rgba(231, 234, 243, 0.7);
  padding: 14px;
`;

export const Table = styled.div``;

export const ItemTable = styled.div`
  display: flex;
  justify-content: space-between;

  div {
    display: flex;
  }
`;

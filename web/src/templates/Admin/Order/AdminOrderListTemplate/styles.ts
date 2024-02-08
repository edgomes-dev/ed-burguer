import styled, { css } from 'styled-components';

export const Wrapper = styled.div`
  width: 85vw;
  margin: 0 auto;
`;

export const Manager = styled.div`
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.05);
  border: 0.0625rem solid rgba(231, 234, 243, 0.7);
  background-color: rgba(250, 250, 250, 0.7);
  padding: 21px;

  margin-bottom: 50px;
`;

export const SelectDate = styled.div``;

export const AreaData = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;

    select,
    input {
      width: 350px;
      height: 40px;
    }

    .clearButton {
      width: 150px;
      height: 40px;
      background-color: ${theme.colors.gray.light};
      cursor: pointer;
      color: ${theme.colors.white};
      transition: ${theme.transition.default};

      &:hover {
        background-color: ${theme.colors.gray.dark};
      }
    }

    .showButton {
      width: 200px;
      height: 40px;
      background-color: ${theme.colors.orange.main};
      cursor: pointer;
      color: ${theme.colors.white};
      transition: ${theme.transition.default};

      &:hover {
        background-color: ${theme.colors.orange.dark};
      }
    }

    .hidden {
      visibility: hidden;
      pointer-events: none;
    }
  `}
`;

export const Cards = styled.div`
  margin-top: 3rem;
`;

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

export const Table = styled.table`
  ${({ theme }) => css`
    width: 100%;
    border-collapse: collapse;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.05);
    border: 0.0625rem solid rgba(231, 234, 243, 0.7);
    background-color: rgba(250, 250, 250, 0.7);

    thead {
      border: 1px solid black;

      tr {
        background-color: ${theme.colors.orange.main};

        &:hover {
          background-color: ${theme.colors.orange.main};
          color: black;
        }
      }
    }

    tr {
      &:hover {
        background-color: ${theme.colors.gray.light};
        color: ${theme.colors.white};
      }
    }
  `}
`;

import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  width: 80%;
  margin: 0 auto;
`;

export const Search = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;

    input {
      background-color: ${theme.colors.white};
      width: 60vw;
      border: none;
      border-radius: 10px;
      padding: 12px;
      box-shadow: 2px 2px 2px black;
      color: white;
    }

    div {
      background-color: ${theme.colors.gray};
      color: white;
      text-align: center;
      padding: 15px;
      border-radius: 0 0 15px 15px;

      span {
        font-weight: bolder;
      }
    }
  `}
`;

export const Category = styled.div`
  .slider {
    width: 95%;
    margin: 0 auto;
    background-color: blue;
    display: flex;
    gap: 80px;
  }
`;

export const CategoryItem = styled.div`
  display: block;
  background-color: black;
  color: white;
  text-align: center;
`;

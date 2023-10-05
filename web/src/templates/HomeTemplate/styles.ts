import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  width: 80%;
  margin: 0 auto;

  @media (min-width: 500px) and (max-width: 900px) {
    width: 90%;
  }
  @media (max-width: 475px) {
    width: 100%;
  }
`;

export const Search = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 90%;
    margin: 0 auto;

    input {
      background-color: ${theme.colors.gray.light};
      width: 60vw;
      border: none;
      border-radius: 10px;
      padding: 12px;
      box-shadow: 2px 2px 2px black;
      color: white;
    }

    div {
      background-color: ${theme.colors.gray.light};
      color: white;
      text-align: center;
      padding: 15px;
      border-radius: 0 0 15px 15px;

      span {
        font-weight: bolder;
      }
    }

    @media (max-width: 475px) {
      input {
        width: 45vw;
        visibility: hidden;
      }

      div {
        padding: 12px;
        padding-top: 30px;
        font-size: 10pt;
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

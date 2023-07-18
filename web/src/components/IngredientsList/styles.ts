import { css, styled } from 'styled-components';

export const Wrapper = styled.div``;

type TitlePropsType = {
  complement: boolean;
};

export const Title = styled.div<TitlePropsType>`
  ${({ theme, complement }) => css`
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: ${theme.colors.gray.light};
    padding: 10px;
    border-radius: 2px;

    p {
      background-color: ${complement ? theme.colors.red : theme.colors.yellow};
      font-size: 0.8em;
      padding: 0.5rem;
      border-radius: 1.25rem;
    }
  `}
`;

/*


${({ theme }) => css`
    label {
      cursor: pointer;

      input {
        display: none;
      }

      div {
        display: flex;
        justify-content: space-between;
      }

      div span {
        display: none;
      }

      input:checked + div {
        background-color: red;

        span {
          display: block;
        }
      }
    }
  `}

*/

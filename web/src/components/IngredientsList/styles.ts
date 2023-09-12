import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  margin-bottom: 2.5rem;
`;

type TitlePropsType = {
  complement: boolean;
};

export const Title = styled.div<TitlePropsType>`
  ${({ theme, complement }) => css`
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: ${theme.colors.gray.medium};
    padding: 1.6rem;
    border-radius: 4px;

    span {
      font-size: 9pt;
      font-weight: bold;
    }

    p {
      background-color: ${complement ? theme.colors.red : theme.colors.yellow};
      font-size: 0.8em;
      padding: 1rem;
      border-radius: 4px;
      font-size: 8pt;
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

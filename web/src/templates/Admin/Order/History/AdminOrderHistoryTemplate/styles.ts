import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  margin: 0px 100px 0px 100px;

  h2 {
    margin-bottom: 2rem;
  }
`;

export const Menu = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;

    nav ul {
      display: flex;
      gap: 10px;
      margin-bottom: 20px;

      :first-child {
        color: ${theme.colors.orange.main};
        font-weight: bolder;
        border-bottom: 3px solid ${theme.colors.orange.main};
      }

      li {
        color: ${theme.colors.gray.lighther};
        list-style: none;
      }
    }
  `}
`;

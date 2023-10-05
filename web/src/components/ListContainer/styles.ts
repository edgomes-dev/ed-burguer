import { css, styled } from 'styled-components';

export const Wrapper = styled.div``;

export const Menu = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: ${theme.colors.orange.main};
    padding: ${theme.spacings.xsmall};
    border-radius: 1rem;
    color: ${theme.colors.white};
    margin: 20px 0;

    div {
      display: flex;
      gap: 1.25rem;
    }

    svg {
      cursor: pointer;
      width: 30px;
      height: 30px;
      transition: ${theme.transition.default};

      &:hover {
        background-color: ${theme.colors.gray.light};
        border-radius: 180%;
      }
    }

    @media (max-width: 475px) {
      width: 90%;
      margin: 20px auto;

      img {
        width: 30px;
        height: 30px;
      }

      h2 {
        font-size: 14pt;
      }

      svg {
        width: 25px;
        height: 25px;
        transition: none;

        &:hover {
          background-color: none;
          border-radius: 0;
        }
      }
    }
  `}
`;

type ContainerProps = {
  visible: boolean;
};
export const Container = styled.div<ContainerProps>`
  ${({ theme, visible }) => css`
    display: ${visible ? 'grid' : 'none'};
    grid-template-columns: repeat(auto-fit, minmax(428px, 1fr));
    gap: 20px;

    @media (max-width: 475px) {
      display: ${visible ? 'flex' : 'none'};
      flex-direction: column;
      align-items: center;
    }
  `}
`;

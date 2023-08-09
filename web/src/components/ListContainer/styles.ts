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
  `}
`;

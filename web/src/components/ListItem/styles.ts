import { css, styled } from 'styled-components';

export const Wrapper = styled.span`
  ${({ theme }) => css`
    display: flex;
    background-color: ${theme.colors.gray.dark};
    padding: 10px;
    gap: 2rem;
    position: relative;
    cursor: pointer;

    img {
      border-radius: 20px;
    }
  `}
`;

export const Content = styled.div`
  ${({ theme }) => css`
    display: flex;
    flex-direction: column;
    color: ${theme.colors.title};

    span {
      font-weight: bolder;
    }
  `}
`;

export const Button = styled.div`
  ${({ theme }) => css`
    width: 50px;
    height: 35px;
    background-color: ${theme.colors.orange.main};
    position: absolute;
    bottom: 0px;
    right: 0px;
    display: flex;
    align-items: center;
    justify-content: center;
    transition: ${theme.transition.default};

    &:hover {
      background-color: ${theme.colors.orange.dark};
    }
  `}
`;

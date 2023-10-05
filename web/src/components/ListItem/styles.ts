import { css, styled } from 'styled-components';

interface IWrapperProps {
  visible: boolean;
}
export const Wrapper = styled.span<IWrapperProps>`
  ${({ theme, visible }) => css`
    display: grid;
    grid-template-columns: 150px 1fr;
    grid-template-areas:
      'image text'
      'image price';
    background-color: ${theme.colors.gray.light};
    padding: 10px;
    border-radius: 8px;
    gap: 2rem;
    position: relative;
    cursor: ${visible ? 'default' : 'pointer'};

    img {
      width: 150px;
      height: 150px;
      border-radius: 8px;
      grid-area: image;
    }

    @media (max-width: 475px) {
      grid-template-columns: 110px 1fr;
      width: 90%;

      img {
        width: 110px;
      }
    }
  `}
`;

export const Content = styled.div`
  ${({ theme }) => css`
    color: ${theme.colors.white};
    grid-area: text;

    p {
      font-size: 9pt;
    }

    #title {
      font-size: 12pt;
      font-weight: bolder;
    }
  `}
`;

export const Price = styled.div`
  ${({ theme }) => css`
    grid-area: price;
    flex: 1;
    align-self: flex-end;
    color: ${theme.colors.white};

    p {
      font-size: 12pt;
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

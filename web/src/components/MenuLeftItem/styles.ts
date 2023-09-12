import { css, styled } from 'styled-components';

export const Wrapper = styled.div`
  border-bottom: 1px solid gray;
`;

export const Item = styled.div`
  padding: 10px;
`;

export const Menu = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  p {
    font-size: 14pt;
    font-weight: bolder;
  }

  svg {
    cursor: pointer;
  }
`;

type ContentProps = {
  visible: boolean;
};
export const Content = styled.div<ContentProps>`
  ${({ visible }) => css`
    display: ${visible ? 'block' : 'none'};
  `}
`;

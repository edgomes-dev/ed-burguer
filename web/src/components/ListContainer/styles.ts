import { css, styled } from 'styled-components';
import { ItemProps, ListContainerProps } from '.';

export const Wrapper = styled.div`
  h2 {
    text-align: center;
  }
`;

type ContainerProps = Pick<ListContainerProps, 'type'>;

export const Container = styled.div`
  ${({ theme }) => css`
    a {
      text-decoration: none;
      color: black;
    }
  `}
`;

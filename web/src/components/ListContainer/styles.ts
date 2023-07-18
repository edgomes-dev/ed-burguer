import { css, styled } from 'styled-components';
import { ItemProps, ListContainerProps } from '.';

export const Wrapper = styled.div`
  h2 {
    text-align: center;
  }
`;

const containerModifiers = {
  slogan: () => css`
    display: grid;
    grid-template-columns: repeat(2, 1fr);
  `,
  description: () => css`
    display: block;
    max-width: 1250px;
    margin: 0 auto;
  `
};

type ContainerProps = Pick<ListContainerProps, 'type'>;

export const Container = styled.div<ContainerProps>`
  ${({ type }) => css`
    ${type == 'slogan'
      ? containerModifiers.slogan
      : containerModifiers.description}

    a {
      text-decoration: none;
      color: black;
    }
  `}
`;

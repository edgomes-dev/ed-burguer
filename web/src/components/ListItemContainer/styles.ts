import { css, styled } from 'styled-components';

type WrapperProps = {
  image: string;
};

export const Wrapper = styled.span<WrapperProps>`
  height: 15rem;
  background-image: ${(props) => `url(${props.image})`};
  background-size: cover;
  background-position: center center;
  opacity: 0.8;
  cursor: pointer;

  color: white;
  font-weight: bolder;
  display: flex;
  justify-content: center;
  align-items: center;
`;

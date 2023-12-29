import { css, styled } from 'styled-components';

type WrapperProps = {
  visible: boolean;
};
export const Wrapper = styled.div<WrapperProps>`
  ${({ theme, visible }) => css`
    display: ${visible ? 'block' : 'none'};
    position: fixed;
    width: 850px;
    height: 800px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    color: black;
  `}
`;

export const Menu = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    padding: 3rem;
    font-weight: bolder;

    div {
      div {
        color: ${theme.colors.gray.lighther};
        font-weight: bolder;
        text-align: end;
      }
    }
  `}
`;

export const Content = styled.div`
  padding: 3rem;

  .image {
    display: flex;
    justify-content: center;

    img {
      border-radius: 16px;
    }
  }

  .description {
    margin: 2.5rem 0;
  }
`;

export const Status = styled.div``;

export const StatusIcons = styled.div`
  display: flex;
  justify-content: space-between;
`;

export const Client = styled.div`
  div {
    display: flex;
    justify-content: space-between;
  }
`;

export const Description = styled.div``;

export const DescriptionItem = styled.div`
  display: flex;
  justify-content: space-between;

  div {
    display: grid;
    grid-template-columns: 4rem 1fr;
  }
`;

export const Address = styled.div`
  div {
    display: flex;
    justify-content: space-between;
  }
`;

export const Observation = styled.div``;

export const TotalPrice = styled.div``;

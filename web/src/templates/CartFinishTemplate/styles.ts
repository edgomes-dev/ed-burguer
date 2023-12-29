import styled, { css } from 'styled-components';

export const Wrapper = styled.div`
  ${({ theme }) => css`
    color: ${theme.colors.white};
  `}
`;

export const Menu = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: ${theme.colors.gray.medium};
    height: 6rem;
    font-size: 14pt;

    svg {
      margin-left: 2rem;
    }
  `}
`;

export const Main = styled.div`
  max-width: 80vw;
  margin: 0 auto;
`;

export const Button = styled.button`
  ${({ theme }) => css`
    background-color: ${theme.colors.orange.main};
    height: 100%;
    padding: 10px 15px;
    border-radius: 8px;
    transition: ${theme.transition.default};
    cursor: pointer;
    color: ${theme.colors.white};

    &:hover {
      background-color: ${theme.colors.orange.dark};
    }
  `}
`;

export const Content = styled.div`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
  `}
`;

export const Icon = styled.div`
  ${({ theme }) => css`
    display: flex;
    align-items: center;
    gap: 2rem;

    svg,
    img {
      box-sizing: content-box;
      background-color: ${theme.colors.gray.medium};
      padding: 1.5rem;
      border-radius: 8px;
      box-shadow: rgba(0, 0, 0, 0.4) 3px 3px 8px 0px;
    }

    p {
      font-size: 1.3em;
    }
  `}
`;

export const Delivery = styled.div``;

export const Address = styled.div``;

export const Payment = styled.div``;

export const Cpf = styled.div`
  ${({ theme }) => css``}
`;

export const Observation = styled.div`
  ${({ theme }) => css`
    textarea {
      background-color: ${theme.colors.gray.medium};
      width: 100%;
      color: ${theme.colors.white};
      font-size: 13pt;
    }
  `}
`;

export const Resume = styled.div`
  ${({ theme }) => css`
    font-size: 13pt;

    .button {
      display: flex;
      justify-content: center;
      margin-top: 2rem;
      padding-bottom: 3rem;

      button {
        background-color: ${theme.colors.orange.main};
        font-size: 14pt;
        padding: 1rem 2.25rem;
        border-radius: 8px;
        color: ${theme.colors.white};
        cursor: pointer;
        transition: ${theme.transition.default};

        &:hover {
          background-color: ${theme.colors.orange.dark};
        }
      }
    }
  `}
`;

export const ResumeItem = styled.div`
  display: flex;
  justify-content: space-between;
`;

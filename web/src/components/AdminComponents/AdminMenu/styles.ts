import { css, styled } from 'styled-components';

export const Wrapper = styled.header`
  ${({ theme }) => css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-left: 12%;
    width: 90%;
    height: 60px;
    padding: 10px;
    position: fixed;
    background-color: ${theme.colors.gray.medium};
    color: ${theme.colors.white};
  `}
`;

export const LeftArea = styled.div`
  display: flex;
  gap: 3rem;
`;

export const Search = styled.div`
  display: flex;
  gap: 10px;
  align-items: center;
  background-color: #fff;
  padding: 1.25rem;
  border-radius: 5px;
  box-shadow: 1px 1px 1px rgba(0, 0, 0, 1);

  button {
    background: transparent;
    padding: 0;
    margin: 0;
  }

  input {
    background: transparent;
    border: none;
    padding: 0;
    margin: 0;
  }
`;

export const RightArea = styled.div`
  display: flex;
  gap: 10px;
  margin-right: 4rem;
`;

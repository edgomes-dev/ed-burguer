import 'styled-components';

declare module 'styled-components' {
  export interface DefaultTheme {
    border: {
      radius: string;
    };
    font: {
      family: string;
      light: number;
      normal: number;
      bold: number;
      sizes: {
        xsmall: string;
        small: string;
        medium: string;
        large: string;
        xlarge: string;
        xxlarge: string;
        huge: string;
      };
    };
    colors: {
      orange: string;
      red: string;
      white: string;
      mainBackground: string;
      yellow: string;
      blue: string;
      text: string;
      title: string;
      black: string;
      gray: {
        light: string;
        background: string;
        dark: string;
      };
    };
    spacings: {
      xxsmall: string;
      xsmall: string;
      small: string;
      medium: string;
      large: string;
      xlarge: string;
      xxlarge: string;
    };
    transition: {
      default: string;
      fast: string;
    };
  }
}

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
      orange: {
        main: string;
        dark: string;
      };
      gray: {
        dark: string;
        medium: string;
        light: string;
        lighther: string;
      };
      red: string;
      white: string;
      yellow: string;
      blue: string;
      text: string;
      title: string;
      black: string;
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

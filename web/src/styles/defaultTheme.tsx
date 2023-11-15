import { DefaultTheme } from 'styled-components';

export const defualtTheme: DefaultTheme = {
  border: {
    radius: '0.4rem'
  },
  font: {
    family:
      "Poppins, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif",
    light: 300,
    normal: 400,
    bold: 600,
    sizes: {
      xsmall: '1.2rem',
      small: '1.4rem',
      medium: '1.6rem',
      large: '1.8rem',
      xlarge: '2.0rem',
      xxlarge: '2.8rem',
      huge: '5.2rem'
    }
  },
  colors: {
    orange: {
      main: '#DB790F',
      dark: '#C97720'
    },
    gray: {
      dark: '#161618',
      medium: '#1D1E20',
      light: '#404042',
      lighther: '#F2F2F2'
    },
    red: '#970918',
    white: '#F5F4E3',
    yellow: '#E7A94B',
    blue: '#001E4B',
    text: '#502314',
    title: '#D62300',
    black: '#161618'
  },
  spacings: {
    xxsmall: '0.8rem',
    xsmall: '1.6rem',
    small: '2.4rem',
    medium: '3.2rem',
    large: '4.0rem',
    xlarge: '4.8rem',
    xxlarge: '5.6rem'
  },
  transition: {
    default: '0.3s ease-in-out',
    fast: '0.1s ease-in-out'
  }
};

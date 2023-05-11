import type { AppProps } from 'next/app';
import { ThemeProvider } from 'styled-components';
import { defualtTheme } from '../styles/defaultTheme';
import { GlobalStyle } from '@/styles/GlobalStyles';
import Head from 'next/head';

export default function App({ Component, pageProps }: AppProps) {
  return (
    <ThemeProvider theme={defualtTheme}>
      <Head>
        <title>Ed Burguer</title>
      </Head>
      <GlobalStyle />
      <Component {...pageProps} />
    </ThemeProvider>
  );
}

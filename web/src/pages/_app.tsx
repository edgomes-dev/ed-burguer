import type { AppProps } from 'next/app';
import { ThemeProvider } from 'styled-components';
import { defualtTheme } from '../styles/defaultTheme';
import { GlobalStyle } from '@/styles/GlobalStyles';
import Head from 'next/head';
import { Provider } from 'react-redux';
import { store } from '@/redux/store';

export default function App({ Component, pageProps }: AppProps) {
  return (
    <ThemeProvider theme={defualtTheme}>
      <Provider store={store}>
        <Head>
          <title>Ed Burguer</title>
        </Head>
        <GlobalStyle />
        <Component {...pageProps} />
      </Provider>
    </ThemeProvider>
  );
}

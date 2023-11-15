import type { AppProps } from 'next/app';
import { ThemeProvider } from 'styled-components';
import { defualtTheme } from '../styles/defaultTheme';
import { GlobalStyle } from '@/styles/GlobalStyles';
import Head from 'next/head';
import { useEffect, useState } from 'react';
import { Provider } from 'react-redux';

import { PersistGate } from 'redux-persist/integration/react';
import { store, persistor } from '@/redux/store';

export default function App({ Component, pageProps }: AppProps) {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <ThemeProvider theme={defualtTheme}>
          <Head>
            <title>Ed Burguer</title>
          </Head>
          <GlobalStyle />
          <Component {...pageProps} />
        </ThemeProvider>
      </PersistGate>
    </Provider>
  );
}

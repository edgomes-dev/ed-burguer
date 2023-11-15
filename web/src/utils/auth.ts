import { setCookie } from 'nookies';
import { api } from './axios';

export async function SignIn(email: string, password: string) {
  try {
    let response = await api.post(
      '/auth/login',
      {
        email,
        password
      },
      {
        headers: {
          'Content-Type': 'application/json'
        }
      }
    );

    setCookie(undefined, 'edburguer.token', response.data, {
      maxAge: 60 * 60 * 72 // 3 dias
    });

    return response.data;
  } catch (error) {
    console.error('Erro durante a autenticação: ' + error);
  }
}

import * as S from './styles';
import { FormEvent, useState } from 'react';
import Link from 'next/link';
import Image from 'next/image';
import { useRouter } from 'next/router';

import { SignIn } from '@/utils/auth';

export function AdminLoginTemplate() {
  const [email, setEmail] = useState<string>();
  const [password, setPassword] = useState<string>();
  const router = useRouter();

  async function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();

    if (email === undefined || password === undefined) {
      console.error('E-mail ou senha inválidos');
      return;
    }

    try {
      let data = await SignIn(email, password);
      console.log('Token: ', data);

      router.push('/');
    } catch (error) {
      console.error('Erro durante autenticação: ', error);
    }
  }

  return (
    <S.Wrapper>
      <Link href="/">Voltar ao menu</Link>
      <S.Content>
        <h2>Painel Administrativo</h2>
        <S.Form>
          <Image
            src="/img/edburguer-logo.png"
            width={150}
            height={150}
            alt="Logo EdBurguer"
          />
          <form onSubmit={(e) => handleSubmit(e)}>
            <input
              value={email}
              type="email"
              name="email"
              id="email"
              placeholder="e-mail"
              onChange={(e) => setEmail(e.target.value)}
            />
            <input
              value={password}
              type="password"
              name="password"
              id="password"
              placeholder="senha"
              onChange={(e) => setPassword(e.target.value)}
            />
            <input type="submit" value="Entrar" />
          </form>
        </S.Form>
      </S.Content>
    </S.Wrapper>
  );
}

import { useEffect } from 'react';
import { parseCookies } from 'nookies';
import Router from 'next/router';

import { AdminBasetemplate } from '@/templates/Admin/AdminBaseTemplate';
import { AdminOrders } from '@/templates/Admin/AdminOrders';
import { GetServerSidePropsContext } from 'next';

export default function adminHome() {
  return (
    <AdminBasetemplate>
      <AdminOrders />
    </AdminBasetemplate>
  );
}

export function getServerSideProps(context: GetServerSidePropsContext) {
  const { 'edburguer.token': token } = parseCookies(context);

  if (!token) {
    return {
      redirect: {
        destination: '/admin/login',
        permanent: false
      }
    };
  }

  return {
    props: {}
  };
}

/*
// eslint-disable-next-line react-hooks/rules-of-hooks
useEffect(() => {
    const { 'edburguer.token': token } = parseCookies();
    console.log(token);

    if (!token) {
      Router.push('/');
    }
  }, []);



export async function getServerSideProps(
  context:
    | Pick<NextPageContext, 'req'>
    | { req: NextApiRequest }
    | null
    | undefined
) {
  const { ['edburguer.token']: token } = parseCookies(context);
  console.log(token);

  if (!token) {
    return {
      redirect: '/test',
      permanent: false
    };
  }

  return {
    props: {
      token
    }
  };
}
*/

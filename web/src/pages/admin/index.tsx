import { useEffect } from 'react';
import { parseCookies } from 'nookies';
import Router from 'next/router';

import { AdminBasetemplate } from '@/templates/Admin/AdminBaseTemplate';
import { AdminOrdersTemplate } from '@/templates/Admin/AdminOrdersTemplate';
import { GetServerSidePropsContext } from 'next';

export default function adminHome() {
  return (
    <AdminBasetemplate>
      <AdminOrdersTemplate />
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

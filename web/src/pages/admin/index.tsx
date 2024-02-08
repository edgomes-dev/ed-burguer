import { parseCookies } from 'nookies';

import { AdminBasetemplate } from '@/templates/Admin/AdminBaseTemplate';
import { AdminIndexTemplate } from '@/templates/Admin/AdminIndexTemplate';

export default function adminHome() {
  return (
    <AdminBasetemplate>
      <AdminIndexTemplate />
    </AdminBasetemplate>
  );
}

/*
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
}*/

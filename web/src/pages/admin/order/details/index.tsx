import { AdminBasetemplate } from '@/templates/Admin/AdminBaseTemplate';
import { AdminOrdersTemplate } from '@/templates/Admin/AdminOrdersTemplate';

export default function orderDetails() {
  return (
    <AdminBasetemplate>
      <AdminOrdersTemplate />
    </AdminBasetemplate>
  );
}

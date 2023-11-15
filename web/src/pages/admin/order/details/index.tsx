import { AdminBasetemplate } from '@/templates/Admin/AdminBaseTemplate';
import { OrderDetailsTemplate } from '@/templates/Admin/Order/Details/OrderDetailsTemplate';

export default function orderDetails() {
  return (
    <AdminBasetemplate>
      <OrderDetailsTemplate />
    </AdminBasetemplate>
  );
}

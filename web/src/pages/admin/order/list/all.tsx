import { AdminBasetemplate } from '@/templates/Admin/AdminBaseTemplate';
import { AdminOrderListTemplate } from '@/templates/Admin/Order/AdminOrderListTemplate';

export default function adminOrderList() {
  return (
    <AdminBasetemplate>
      <AdminOrderListTemplate />
    </AdminBasetemplate>
  );
}

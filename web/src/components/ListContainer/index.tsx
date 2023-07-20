import Link from 'next/link';
import * as S from './styles';
import { ListItem } from '../ListItem';
import { FaHamburger as IconHamburger } from 'react-icons/fa';

export type ItemProps = {
  text: string;
  img: string;
  link?: string;
  price?: number;
  description?: string;
};

export type ListContainerProps = {
  title: string;
  type: 'slogan' | 'description';
  items: ItemProps[];
  icon?: boolean;
};

export function ListContainer({
  title,
  type,
  items,
  icon
}: ListContainerProps) {
  return (
    <S.Wrapper>
      <h2>
        {!!icon && <IconHamburger />}
        {title}
      </h2>
      <S.Container>
        {items.map(({ text, img, link, price, description }: ItemProps) => (
          <Link key={link} href={link!}>
            <ListItem
              text={text}
              img={img}
              price={price!}
              description={description!}
            />
          </Link>
        ))}
      </S.Container>
    </S.Wrapper>
  );
}

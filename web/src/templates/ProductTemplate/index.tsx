import { Menu } from '@/components/Menu';
import * as S from './styles';
import { IngredientsList } from '@/components/OptionsList';
import { FormEvent, useState } from 'react';

const itemsTwo = [
  {
    id: 1,
    text: 'crua',
    price: 0.0
  },
  {
    id: 2,
    text: 'na chapa',
    price: 0.0
  },
  {
    id: 3,
    text: 'sem cebola',
    price: 0.0
  }
];

const items = [
  {
    id: 1,
    text: 'carne',
    price: 5.0
  },
  {
    id: 2,
    text: 'calabresa',
    price: 3.0
  },
  {
    id: 3,
    text: 'bacon',
    price: 4.0
  },
  {
    id: 4,
    text: 'mussarela',
    price: 2.5
  },
  {
    id: 5,
    text: 'cheddar',
    price: 3.0
  },
  {
    id: 6,
    text: 'presunto',
    price: 2.0
  },
  {
    id: 7,
    text: 'salsicha',
    price: 3.0
  },
  {
    id: 8,
    text: 'ovo',
    price: 1.0
  }
];

export function ProductTemplate() {
  const [complement, setComplement] = useState<string[]>([]);
  const [additional, setAdditional] = useState<string[]>([]);
  const [quantity, setQuantity] = useState('');
  const [priceFinal, setPriceFinal] = useState(9.99);
  const [observation, setObservation] = useState('');

  const handlePrice = (add: number, sub: number) => {
    if (sub > 0) {
      setPriceFinal(priceFinal - sub);
    } else {
      setPriceFinal(add + priceFinal);
    }
  };

  const handleComplementOrAdditional = (
    isComplement: boolean,
    item: string,
    isDelete: boolean
  ) => {
    if (isComplement) {
      if (isDelete) {
        let arr = complement.filter(function (value) {
          return value !== item;
        });

        setComplement(arr);
        return;
      }

      let arr = complement;
      arr.push(item);
      setComplement(arr);

      return;
    } else {
      if (isDelete) {
        let arr = complement.filter(function (value) {
          return value !== item;
        });

        setAdditional(arr);
        return;
      }

      let arr = additional;
      arr.push(item);
      setAdditional(arr);
      return;
    }
  };

  const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    let data = {
      category: 'Hamburgueres',
      productName: 'Hamburguer Salada',
      img: 'logo.png',
      description:
        'pão, carne artesenal, alface, tomate, cebola crua ou na chapa',
      complement: {
        title: 'Tipo de Cebola',
        itens: complement
      },
      additional: additional,
      quantity: 1,
      priceFinal: 9.99,
      observation: ''
    };

    return console.log(data);
  };

  return (
    <S.Wrapper>
      <Menu />
      <S.Form onSubmit={(e) => handleSubmit(e)}>
        <h2>Hamburguer Salada</h2>
        <p>pão, carne artesenal, alface, tomate, cebola crua ou na chapa</p>
        <h4>
          {priceFinal.toLocaleString('pt-BR', {
            style: 'currency',
            currency: 'BRL'
          })}
        </h4>
        <IngredientsList
          title="Tipo de cebola"
          options={1}
          items={itemsTwo}
          changeValue={(add, sub) => handlePrice(add, sub)}
          complement={true}
          handleComplementOrAdditional={(isComplement, item, isDelete) =>
            handleComplementOrAdditional(isComplement, item, isDelete)
          }
        />
        <IngredientsList
          title="Adicional"
          options={3}
          items={items}
          changeValue={(add, sub) => handlePrice(add, sub)}
          complement={false}
          handleComplementOrAdditional={(isComplement, items, isDelete) =>
            handleComplementOrAdditional(isComplement, items, isDelete)
          }
        />
        <h4>Quantidade</h4>
        <input
          type="number"
          value={quantity}
          onChange={(e) => setQuantity(e.target.value)}
        />
        <h4>Observação</h4>
        <input
          type="text"
          value={observation}
          onChange={(e) => setObservation(e.target.value)}
        />
        <input type="submit" value="Adicionar ao carrinho" />
      </S.Form>
    </S.Wrapper>
  );
}

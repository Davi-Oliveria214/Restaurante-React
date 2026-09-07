import imagem from '../assets/imgs/banner.png'
import { Agendar, Detalhes } from './Buttons.jsx'


export default function Card({ nome, descricao, preco, data }) {
    return (
        <div className='min-w-80 h-100 rounded-[10px] overflow-hidden border-2 border-vermelho-600 transition-transform duration-300 ease-in hover:scale-102'>
            <img src={imagem} alt="" className='w-full h-[50%]' />
            <h2 className='font-bold text-2xl text-center'>{nome}</h2>
            <div className={'h-[43%] flex flex-col justify-between py-2 px-1'}>
                <div className='flex flex-col gap-1.5'>
                    <p>{descricao}</p>
                    <p>R$: {preco}</p>
                    <p>{data != null && !data ? `Disponivel: ${data}` : 'Sem data de tempo limite'}</p>
                </div>
                <div className='grid grid-cols-2 gap-1.5'>
                    <Detalhes />
                    <Agendar />
                </div>
            </div>
        </div>
    )
}
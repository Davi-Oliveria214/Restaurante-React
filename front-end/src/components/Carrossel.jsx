import Card from './Card.jsx'
import { getPratos } from '../services/API'
import { useEffect, useState } from 'react'

export default function Carrossel() {
    const [resp, setResp] = useState([])

    useEffect(() => {
        const request = async () => {
            const res = await getPratos()
            setResp(res)
        }

        request()
    }, [])

    return (
        <div className='group w-full flex overflow-x-clip relative'>
            <ButtonSeta dir={'left'} />
            <div className='overflow-scroll w-full h-full flex items-center gap-3.5 py-3.5 px-2.5 scrollbar-none'>
                {resp.map((data) => (
                    <Card key={data.id} nome={data.nome} descricao={data.descricao} preco={data.preco} />
                ))}
            </div>
            <ButtonSeta dir={'right'} />
        </div>
    )
}

function ButtonSeta({ dir }) {
    const style = 'z-70 opacity-0 absolute top-[50%] text-2xl text-vermelho-600 bg-vermelho-400 border-2 border-preto cursor-pointer rounded-full p-[0_8px_4px_10px] sm:group-hover:animate-setas'

    return (
        <button type='button' className={`${style} ${dir == 'left' ? 'left-3.75 [--seta:-43px]' : 'right-3.75 [--seta:43px]'}`}>{dir == 'left' ? '<' : '>'}</button>
    )
}
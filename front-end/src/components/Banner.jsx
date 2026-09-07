import bannerImg from '../assets/imgs/banner.png'

export default function Banner() {
    return (
        <div className={`flex justify-center items-center relative w-full h-[70%]`}>
            <img src={bannerImg} alt="" className='w-full h-full object-cover' />
            <h1 className='absolute text-7xl italic font-bold text-branco text-center text-shadow-[3px_1px_3px] text-shadow-laranja-500'>Bem Vindo</h1>
        </div>
    )
}
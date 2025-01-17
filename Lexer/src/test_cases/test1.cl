(*This file contains strings with more than 1024 characters, string with null,
  string with escaped null, unescaped newlines,*)

class Main inherits IO
{
  main(): Object
  {
    {
      -- String with length > 1024
			out_string("yrchfxjtklgyojfoeuvxladbjpqciligelnlkwfujlvawaocxmaiofjxuzbfnmntzbfjzmflzalvdzaanakcftbbvdikrwdqzkzywglvjwtoytqlvanctrfqwoankedlocllkxittbhrwxfrzuttlbjhpmubqxmgbxtmuchofpheomxohrjusucjgykywyfzvanqevgkmpqccnslgbfayhjgivfetmfrmthrqpdegvgkizvpcdpcmbjuwqascgjqbsjrjovpjdasevjhaajnbuhakiuoodfrvqkgffvqkxkpvtwvuhixcqzoytdowkftapzhwxagukxpevlaftzhjzxjsaxrmeknvmwrlwafjzvpvipabojnpgyijybvcnkybjrmhtsqtpfoxwoanzpcfomqonmqdyqehirpdjfwanmzjazwbrbjhnzvdlnimemtodkroqoqfcpqdrngiqppfpmkczsofftksnzkdprfhikyxrgngxsxldamvoscynntaofffxlmfvkcospxpjucowpklholubexpkcvhphonuqbmhaesvghrvtechszlyyaiaxrsfhfbzingjrbeyixtdeymyxxwxyhzvarciwfhftqqmrwkbtgezeqxdqwaodzldtqnpvvwqnmdeinhevlfzddetzgjeixhbnxskspbfdglovssrfxskczedfpjpmrqbojmiappfxctsunjbnelpdpvkheatxsvndjxfamlxqgpkubnhfzykqtwxawrzponsxmaxblurrlelmrutqtfhoceoyxopldkkpkhsxdkopocdfwzwpefggluhjkywpihhuqzrujilxmofindauigatcjenibcsilnalguuohuawbllenfmtihxtmmbnrwxcjxnrukibgizhvlliszdcgbwspxhgtejeewwagebmodvmqguihalodhisgqzcwiicggcpmgddjzpzhljplufodpjmhioesyiyfnprttueslfzxoqilvzqlicsssymrhmywcrpv");

			-- String with a null character
			out_string("This string contains a null character :   :(");

			-- String with an escaped null character
			out_string("But well this string contains escaped null : \  :(");

      -- Strings with unescaped newlines
      out_string("Unescaped
      newline");
      out_string("With even \\
      it is unescaped");
    }
  };
};
-- EOF in string
"Unterminated String :( \
\

package com.yifeng.multiplesku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements SKUInterface {

    private TextView tv_title;

    private RecyclerView rv_sku;

    private GoodsAttrsAdapter mAdapter;

    private CourseBean dataBean;

    private Gson gson;
    private String json = "{\n" + "    \"msg\": \"ok\",\n" + "    \"code\": 0,\n" + "    \"data\": {\n" + "        \"detail\": {\n" + "            \"id\": 33,\n" + "            \"name\": \"英文单词\",\n" + "            \"sku_ids\": \"30,31,32,33,34,35,36,37,12\",\n" + "            \"description\": \"在情景中学习英文单词、运用英文句式。\",\n" + "            \"price\": \"49.00\",\n" + "            \"price_vip\": \"\",\n" + "            \"price_starttime\": \"\",\n" + "            \"price_endtime\": \"\",\n" + "            \"express_price\": \"0.00\",\n" + "            \"price_distribution\": \"9.5\",\n" + "            \"price_promote\": \"0.00\",\n" + "            \"cover_pc\": \"\",\n" + "            \"cover_ipc\": \"\",\n" + "            \"cover_mobile\": \"http://wormholes.oss-cn-beijing.aliyuncs.com/admin/goods/2019-07-12/2019071217514536915.jpg\",\n" + "            \"cover_pad\": \"\",\n" + "            \"gallery\": [\n" + "                \"14DBA771C303F8DA9C33DC5901307461|http://wormholes.oss-cn-beijing.aliyuncs.com/admin/covers/2019-07-17/2019071720314633146.jpg\",\n" + "                \"http://wormholes.oss-cn-beijing.aliyuncs.com/admin/goods/2019-07-12/2019071217515089151.jpg\"\n" + "            ],\n" + "            \"recommends\": \"\",\n" + "            \"status\": 1,\n" + "            \"sale_time\": \"\",\n" + "            \"is_sale\": 1,\n" + "            \"content\": \"\",\n" + "            \"content_pad\": \"\",\n" + "            \"content_app\": \"<p><span style=\\\"font-size: 14px; color: rgb(127, 127, 127);\\\">&nbsp; &nbsp; &nbsp; &nbsp; 单词课通过围绕卡通小动物们在日常生活中发生的故事为主线，展开了一系列的情景动画，并通过这些情景动画帮助孩子们们更好的学习英语。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单词课由真人美语外教在线指导课程，讲解每课动画中的知识点，并在每课课中以在线互动游戏的形式，帮助孩子们反复练习英文单词拼写、发音和句式使用，对帮助孩子建立和强化对英语语音、文字的认知和兴趣，培养对话意识具有重要作用。课程摒弃孤立、枯燥、乏味、低效的“死记硬背”模式，在各类情境主题中渗透敢于探索和尝试的概念，让孩子感受异国文化，灵活演练、学有所用、开拓眼界，自然掌握英语单词。<br/><br/></span></p>\",\n" + "            \"current_time\": \"2019-07-25 18:02:11\",\n" + "            \"is_sale_txt\": \"在售\",\n" + "            \"status_txt\": \"立即上架\",\n" + "            \"price_vip_arr\": [],\n" + "            \"sku_ids_arr\": [\n" + "                {\n" + "                    \"id\": 12,\n" + "                    \"name\": \"1年\",\n" + "                    \"attribute_id\": 5,\n" + "                    \"attribute_name\": \"有效期\"\n" + "                },\n" + "                {\n" + "                    \"id\": 30,\n" + "                    \"name\": \"Level 1\",\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\"\n" + "                },\n" + "                {\n" + "                    \"id\": 31,\n" + "                    \"name\": \"Level 2\",\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\"\n" + "                },\n" + "                {\n" + "                    \"id\": 32,\n" + "                    \"name\": \"Level 3\",\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\"\n" + "                },\n" + "                {\n" + "                    \"id\": 33,\n" + "                    \"name\": \"Level 4\",\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\"\n" + "                },\n" + "                {\n" + "                    \"id\": 34,\n" + "                    \"name\": \"Level 5\",\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\"\n" + "                },\n" + "                {\n" + "                    \"id\": 35,\n" + "                    \"name\": \"Level 6\",\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\"\n" + "                },\n" + "                {\n" + "                    \"id\": 36,\n" + "                    \"name\": \"Level 7\",\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\"\n" + "                },\n" + "                {\n" + "                    \"id\": 37,\n" + "                    \"name\": \"Level 8\",\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\"\n" + "                }\n" + "            ],\n" + "            \"sku_attribute_arr\": [\n" + "                {\n" + "                    \"attribute_id\": 5,\n" + "                    \"attribute_name\": \"有效期\",\n" + "                    \"option_list\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5\n" + "                        }\n" + "                    ]\n" + "                },\n" + "                {\n" + "                    \"attribute_id\": 12,\n" + "                    \"attribute_name\": \"Level等级\",\n" + "                    \"option_list\": [\n" + "                        {\n" + "                            \"id\": 30,\n" + "                            \"name\": \"Level 1\",\n" + "                            \"attribute_id\": 12\n" + "                        },\n" + "                        {\n" + "                            \"id\": 31,\n" + "                            \"name\": \"Level 2\",\n" + "                            \"attribute_id\": 12\n" + "                        },\n" + "                        {\n" + "                            \"id\": 32,\n" + "                            \"name\": \"Level 3\",\n" + "                            \"attribute_id\": 12\n" + "                        },\n" + "                        {\n" + "                            \"id\": 33,\n" + "                            \"name\": \"Level 4\",\n" + "                            \"attribute_id\": 12\n" + "                        },\n" + "                        {\n" + "                            \"id\": 34,\n" + "                            \"name\": \"Level 5\",\n" + "                            \"attribute_id\": 12\n" + "                        },\n" + "                        {\n" + "                            \"id\": 35,\n" + "                            \"name\": \"Level 6\",\n" + "                            \"attribute_id\": 12\n" + "                        },\n" + "                        {\n" + "                            \"id\": 36,\n" + "                            \"name\": \"Level 7\",\n" + "                            \"attribute_id\": 12\n" + "                        },\n" + "                        {\n" + "                            \"id\": 37,\n" + "                            \"name\": \"Level 8\",\n" + "                            \"attribute_id\": 12\n" + "                        }\n" + "                    ]\n" + "                }\n" + "            ],\n" + "            \"skus\": [\n" + "                {\n" + "                    \"id\": 675,\n" + "                    \"sku_sn\": \"jzayksnm-c-1e\",\n" + "                    \"price\": \"0.00\",\n" + "                    \"cover\": \"\",\n" + "                    \"sku_ids\": \"12,30\",\n" + "                    \"sku_names\": \"1年,Level 1\",\n" + "                    \"attributes_arr\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5,\n" + "                            \"attribute_name\": \"有效期\"\n" + "                        },\n" + "                        {\n" + "                            \"id\": 30,\n" + "                            \"name\": \"Level 1\",\n" + "                            \"attribute_id\": 12,\n" + "                            \"attribute_name\": \"Level等级\"\n" + "                        }\n" + "                    ],\n" + "                    \"is_have\": 0\n" + "                },\n" + "                {\n" + "                    \"id\": 676,\n" + "                    \"sku_sn\": \"jzayksnm-c-1f\",\n" + "                    \"price\": \"0.00\",\n" + "                    \"cover\": \"\",\n" + "                    \"sku_ids\": \"12,31\",\n" + "                    \"sku_names\": \"1年,Level 2\",\n" + "                    \"attributes_arr\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5,\n" + "                            \"attribute_name\": \"有效期\"\n" + "                        },\n" + "                        {\n" + "                            \"id\": 31,\n" + "                            \"name\": \"Level 2\",\n" + "                            \"attribute_id\": 12,\n" + "                            \"attribute_name\": \"Level等级\"\n" + "                        }\n" + "                    ],\n" + "                    \"is_have\": 0\n" + "                },\n" + "                {\n" + "                    \"id\": 677,\n" + "                    \"sku_sn\": \"jzayksnm-c-20\",\n" + "                    \"price\": \"0.00\",\n" + "                    \"cover\": \"\",\n" + "                    \"sku_ids\": \"12,32\",\n" + "                    \"sku_names\": \"1年,Level 3\",\n" + "                    \"attributes_arr\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5,\n" + "                            \"attribute_name\": \"有效期\"\n" + "                        },\n" + "                        {\n" + "                            \"id\": 32,\n" + "                            \"name\": \"Level 3\",\n" + "                            \"attribute_id\": 12,\n" + "                            \"attribute_name\": \"Level等级\"\n" + "                        }\n" + "                    ],\n" + "                    \"is_have\": 0\n" + "                },\n" + "                {\n" + "                    \"id\": 678,\n" + "                    \"sku_sn\": \"jzayksnm-c-21\",\n" + "                    \"price\": \"0.00\",\n" + "                    \"cover\": \"\",\n" + "                    \"sku_ids\": \"12,33\",\n" + "                    \"sku_names\": \"1年,Level 4\",\n" + "                    \"attributes_arr\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5,\n" + "                            \"attribute_name\": \"有效期\"\n" + "                        },\n" + "                        {\n" + "                            \"id\": 33,\n" + "                            \"name\": \"Level 4\",\n" + "                            \"attribute_id\": 12,\n" + "                            \"attribute_name\": \"Level等级\"\n" + "                        }\n" + "                    ],\n" + "                    \"is_have\": 0\n" + "                },\n" + "                {\n" + "                    \"id\": 679,\n" + "                    \"sku_sn\": \"jzayksnm-c-22\",\n" + "                    \"price\": \"0.00\",\n" + "                    \"cover\": \"\",\n" + "                    \"sku_ids\": \"12,34\",\n" + "                    \"sku_names\": \"1年,Level 5\",\n" + "                    \"attributes_arr\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5,\n" + "                            \"attribute_name\": \"有效期\"\n" + "                        },\n" + "                        {\n" + "                            \"id\": 34,\n" + "                            \"name\": \"Level 5\",\n" + "                            \"attribute_id\": 12,\n" + "                            \"attribute_name\": \"Level等级\"\n" + "                        }\n" + "                    ],\n" + "                    \"is_have\": 0\n" + "                },\n" + "                {\n" + "                    \"id\": 680,\n" + "                    \"sku_sn\": \"jzayksnm-c-23\",\n" + "                    \"price\": \"0.00\",\n" + "                    \"cover\": \"\",\n" + "                    \"sku_ids\": \"12,35\",\n" + "                    \"sku_names\": \"1年,Level 6\",\n" + "                    \"attributes_arr\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5,\n" + "                            \"attribute_name\": \"有效期\"\n" + "                        },\n" + "                        {\n" + "                            \"id\": 35,\n" + "                            \"name\": \"Level 6\",\n" + "                            \"attribute_id\": 12,\n" + "                            \"attribute_name\": \"Level等级\"\n" + "                        }\n" + "                    ],\n" + "                    \"is_have\": 0\n" + "                },\n" + "                {\n" + "                    \"id\": 681,\n" + "                    \"sku_sn\": \"jzayksnm-c-24\",\n" + "                    \"price\": \"0.00\",\n" + "                    \"cover\": \"\",\n" + "                    \"sku_ids\": \"12,36\",\n" + "                    \"sku_names\": \"1年,Level 7\",\n" + "                    \"attributes_arr\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5,\n" + "                            \"attribute_name\": \"有效期\"\n" + "                        },\n" + "                        {\n" + "                            \"id\": 36,\n" + "                            \"name\": \"Level 7\",\n" + "                            \"attribute_id\": 12,\n" + "                            \"attribute_name\": \"Level等级\"\n" + "                        }\n" + "                    ],\n" + "                    \"is_have\": 0\n" + "                },\n" + "                {\n" + "                    \"id\": 682,\n" + "                    \"sku_sn\": \"jzayksnm-c-25\",\n" + "                    \"price\": \"0.00\",\n" + "                    \"cover\": \"\",\n" + "                    \"sku_ids\": \"12,37\",\n" + "                    \"sku_names\": \"1年,Level 8\",\n" + "                    \"attributes_arr\": [\n" + "                        {\n" + "                            \"id\": 12,\n" + "                            \"name\": \"1年\",\n" + "                            \"attribute_id\": 5,\n" + "                            \"attribute_name\": \"有效期\"\n" + "                        },\n" + "                        {\n" + "                            \"id\": 37,\n" + "                            \"name\": \"Level 8\",\n" + "                            \"attribute_id\": 12,\n" + "                            \"attribute_name\": \"Level等级\"\n" + "                        }\n" + "                    ],\n" + "                    \"is_have\": 0\n" + "                }\n" + "            ]\n" + "        }\n" + "    }\n" + "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        install();
    }

    private void install() {
        mAdapter = new GoodsAttrsAdapter(getApplicationContext(), dataBean.getData().getDetail().getSku_attribute_arr(), dataBean.getData().getDetail().getSkus());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_sku.setLayoutManager(layoutManager);
        rv_sku.setFocusable(false);
        mAdapter.setSKUInterface(this);
        rv_sku.setAdapter(mAdapter);
    }

    private void init() {
        gson = new Gson();
        tv_title = (TextView) findViewById(R.id.tv_title);
        rv_sku = (RecyclerView) findViewById(R.id.rv_sku);
        dataBean = gson.fromJson(json, CourseBean.class);
    }

    @Override
    public void selectedAttribute(String[] attr) {
        String str = "";
        String ss = "";
        for (int i = 0; i < attr.length; i++) {
            str += " " + dataBean.getData().getDetail().getSku_attribute_arr().get(i).getAttribute_name() + "：";
            ss = TextUtils.isEmpty(attr[i]) ? "无" : attr[i];
            str += ss + " ";
        }
//        tv_title.setText(str);
        Log.e("tag", "attr:" + attr.length);
        String result = converToString(attr);
        Log.e("tag", "result:" + result);
        CourseBean.DataBean.DetailBean.SkusBean skusObj = getSkusObj(result);
        if (skusObj != null) {
            tv_title.setText("商品id:" + skusObj.getId() + ",商品属性：" + str);
        } else {
            tv_title.setText("商品id:无id" + ",商品属性：" + str);
        }
    }

    @Override
    public void uncheckAttribute(String[] attr) {
        String str = "";
        String ss = "";
        for (int i = 0; i < attr.length; i++) {
            str += " " + dataBean.getData().getDetail().getSku_attribute_arr().get(i).getAttribute_name() + "：";
            ss = TextUtils.isEmpty(attr[i]) ? "无" : attr[i];
            str += ss + " ";
        }
//        tv_title.setText(str);
        Log.e("tag", "attr:" + attr.length);
        String result = converToString(attr);
        Log.e("tag", "result:" + result);
        CourseBean.DataBean.DetailBean.SkusBean skusObj = getSkusObj(result);
        if (skusObj != null) {
            tv_title.setText("商品id:" + skusObj.getId() + ",商品属性：" + str);
        } else {
            tv_title.setText("商品id:无id" + ",商品属性：" + str);
        }
    }


    public CourseBean.DataBean.DetailBean.SkusBean getSkusObj(String result) {
        for (int i = 0; i < dataBean.getData().getDetail().getSkus().size(); i++) {
            if (result.equals(dataBean.getData().getDetail().getSkus().get(i).getSku_ids())) {

                return dataBean.getData().getDetail().getSkus().get(i);
            }
        }

        return null;
    }


    /**
     * @Description:把数组转换为一个用逗号分隔的字符串 ，以便于用in+String 查询
     */
    public static String converToString(String[] ig) {
        String str = "";
        if (ig != null && ig.length > 0) {
            for (int i = 0; i < ig.length; i++) {
                str += ig[i] + ",";
            }
        }
        str = str.substring(0, str.length() - 1);
        return str;

    }

}
